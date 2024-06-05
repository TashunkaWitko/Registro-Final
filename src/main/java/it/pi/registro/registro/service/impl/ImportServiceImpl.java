package it.pi.registro.registro.service.impl;

import it.pi.registro.registro.configuration.ApiProp;
import it.pi.registro.registro.constant.Constants;
import it.pi.registro.registro.dto.request.CsvImportRequestDTO;
import it.pi.registro.registro.entity.ApiKey;
import it.pi.registro.registro.entity.User;
import it.pi.registro.registro.entity.UserDetail;
import it.pi.registro.registro.exception.ApiValidationException;
import it.pi.registro.registro.exception.BadRequestException;
import it.pi.registro.registro.exception.ResourceNotFoundException;
import it.pi.registro.registro.repository.ApikeyRepository;
import it.pi.registro.registro.repository.UserRepository;
import it.pi.registro.registro.service.AttendanceService;
import it.pi.registro.registro.service.ImportService;
import it.pi.registro.registro.service.UserService;
import lombok.AllArgsConstructor;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.Base64;
import java.util.List;

@Service
@AllArgsConstructor
@Transactional
public class ImportServiceImpl implements ImportService {

    private static final Logger logger = LoggerFactory.getLogger(AttendanceService.class);

    @Autowired
    private UserRepository userRepository;

    private ApikeyRepository apikeyRepository;

    private UserService userService;

    private ApiProp apiProp;

    @Override
    public void importCsv(CsvImportRequestDTO csvImportRequest) {
       // logger.info("Base 64 is:");
       // logger.info(csvImportRequest.getBase64File());
        try {
            byte[] decodedBytes = Base64.getDecoder().decode(csvImportRequest.getBase64File());
            InputStreamReader reader =
                    new InputStreamReader(new ByteArrayInputStream(decodedBytes), StandardCharsets.UTF_8);
            CSVParser csvParser =
                    CSVFormat
                            .DEFAULT
                            .withDelimiter(';')
                            .withFirstRecordAsHeader()
                            .withHeader("FirstName", "LastName", "email", "Password", "Age", "Address", "City", "Type")
                            .parse(reader);

            for (CSVRecord csvRecord : csvParser) {

                userRepository.save(
                        User
                                .builder()
                                .firstName(csvRecord.get("FirstName"))
                                .lastName(csvRecord.get("LastName"))
                                .email(csvRecord.get("email"))
                                .password(csvRecord.get("Password"))
                                .birth_date(LocalDate.now())
                                .userDetail(UserDetail.builder()
                                        .city(csvRecord.get("City"))
                                        .address(csvRecord.get("Address"))
                                        .build())
                                .build()
                );


                String firstName = csvRecord.get("FirstName");
                String lastName = csvRecord.get("LastName");
                String email = csvRecord.get("email");
                String password = csvRecord.get("Password");
                String age = csvRecord.get("Age");
                String address = csvRecord.get("Address");
                String city = csvRecord.get("City");
                String type = csvRecord.get("Type");
            }
            reader.close();
            csvParser.close();
        } catch (DataIntegrityViolationException | IOException e)   {
            throw new BadRequestException(e.getMessage());
        }
    }

    @Override
    public boolean checkApiKey(String apiKey, String URI) {

        if(Arrays.stream(apiProp.getBlackList()).toList().contains(URI)){
            throw new ApiValidationException(
                    Constants.ERROR_API_NOT_VALID_MESSAGE,
                    Constants.ERROR_API_NOT_VALID_CODE);
        }

        if(Arrays.stream(apiProp.getWhiteList()).toList().contains(URI) &&
                !apikeyRepository.findApiKeyByKey(apiKey).isEmpty()){
            return true;
        }
        return false;
    }

    @Override
    public List<User> getusers() {

        System.out.println(apikeyRepository.findApiKeyByKey("0imfnc8mVLWwsAawjYr4Rx-Af50DDqtlx"));
        return userService.getAllUsers();
    }
}