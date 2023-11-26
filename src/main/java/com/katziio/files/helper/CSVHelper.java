package com.katziio.files.helper;

import com.katziio.files.entity.User;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVPrinter;
import org.apache.commons.csv.CSVRecord;
import org.springframework.web.multipart.MultipartFile;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class CSVHelper {

    public static String TYPE = "text/csv";

    static String[] HEADERS = {"userId", "name", "email", "password", "place", "pincode", "area", "landmark", "city", "state", "phoneNumber"};

    public static boolean hasCSVFormat(MultipartFile file) {

        if (!TYPE.equals(file.getContentType())) {
            return false;
        }

        return true;
    }

    public static List<User> csvToUser(InputStream is) {
        try (BufferedReader fileReader = new BufferedReader(new InputStreamReader(is, "UTF-8"));
             CSVParser csvParser = new CSVParser(fileReader,
                     CSVFormat.DEFAULT.withFirstRecordAsHeader().withIgnoreHeaderCase().withTrim())) {

            List<User> userList = new ArrayList<>();

            Iterable<CSVRecord> csvRecords = csvParser.getRecords();

            for (CSVRecord csvRecord : csvRecords) {

                User user = new User(
                        Long.parseLong(csvRecord.get(HEADERS[0])),
                        csvRecord.get(HEADERS[1]),
                        csvRecord.get(HEADERS[2]),
                        csvRecord.get(HEADERS[3]),
                        csvRecord.get(HEADERS[4]),
                        Long.parseLong(csvRecord.get(HEADERS[5])),
                        csvRecord.get(HEADERS[6]),
                        csvRecord.get(HEADERS[7]),
                        csvRecord.get(HEADERS[8]),
                        csvRecord.get(HEADERS[9]),
                        Long.parseLong(csvRecord.get(HEADERS[10]))
                );
                userList.add(user);
            }
            return userList;
        } catch (IOException e) {
            throw new RuntimeException("fail to parse CSV file: " + e.getMessage());
        }
    }

    public static void writeEmployeesToCsv(Writer writer, List<User> userList) {
        try (CSVPrinter csvPrinter = new CSVPrinter(writer, CSVFormat.DEFAULT)) {
            csvPrinter.printRecord("userId", "name", "email", "password", "place", "pincode", "area", "landmark", "city", "state", "phoneNumber");
            for (User user : userList) {
                csvPrinter.printRecord(user.getUserId(), user.getName(), user.getEmail(), user.getPassword(),
                        user.getPlace(), user.getPincode(), user.getArea(), user.getLandmark(), user.getCity(), user.getState(), user.getPhoneNumber());
            }
        } catch (IOException e) {
            throw new RuntimeException("Error While writing CSV ", e);
        }
    }

    public static void writeEmployeesToCsvCustom(PrintWriter writer, List<User> userList, List<String> headerList) {
        try (CSVPrinter csvPrinter = new CSVPrinter(writer, CSVFormat.DEFAULT)) {
            csvPrinter.printRecord(headerList.toArray());

            for (User user : userList) {
                List<String> userData = new ArrayList<>();

                for (String field : headerList) {
                    switch (field.toLowerCase()) {
                        case "userid":
                            userData.add(String.valueOf(user.getUserId()));
                            break;
                        case "name":
                            userData.add(user.getName());
                            break;
                        case "email":
                            userData.add(user.getEmail());
                            break;
                        case "password":
                            userData.add(user.getPassword());
                            break;
                        case "place":
                            userData.add(user.getPlace());
                            break;
                        case "pincode":
                            userData.add(String.valueOf(user.getPincode()));
                            break;
                        case "area":
                            userData.add(user.getArea());
                            break;
                        case "landmark":
                            userData.add(user.getLandmark());
                            break;
                        case "city":
                            userData.add(user.getCity());
                            break;
                        case "state":
                            userData.add(user.getState());
                            break;
                        case "phonenumber":
                            userData.add(String.valueOf(user.getPhoneNumber()));
                            break;
                        default:
                            userData.add("");
                            break;
                    }
                }

                csvPrinter.printRecord(userData);
            }
        } catch (IOException e) {
            throw new RuntimeException("Error while writing CSV", e);
        }
    }
}