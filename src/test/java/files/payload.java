package files;

public class payload {
    public static String CoursePrice() {
    return "{\n" +
            "\n" +
            "\"dashboard\": {\n" +
            "\n" +
            "\"purchaseAmount\": 910,\n" +
            "\n" +
            "\"website\": \"rahulshettyacademy.com\"\n" +
            "\n" +
            "},\n" +
            "\n" +
            "\"courses\": [\n" +
            "\n" +
            "{\n" +
            "\n" +
            "\"title\": \"Selenium Python\",\n" +
            "\n" +
            "\"price\": 50,\n" +
            "\n" +
            "\"copies\": 6\n" +
            "\n" +
            "},\n" +
            "\n" +
            "{\n" +
            "\n" +
            "\"title\": \"Cypress\",\n" +
            "\n" +
            "\"price\": 40,\n" +
            "\n" +
            "\"copies\": 4\n" +
            "\n" +
            "},\n" +
            "\n" +
            "{\n" +
            "\n" +
            "\"title\": \"RPA\",\n" +
            "\n" +
            "\"price\": 45,\n" +
            "\n" +
            "\"copies\": 10\n" +
            "\n" +
            "}\n" +
            "\n" +
            "]\n" +
            "\n" +
            "}\n" +
            "\n";
    }

    public static String AddBook(String isbn, String aisle) {
        return "{\n" +
                "\n" +
                "\"name\":\"Learn Automation with Java\",\n" +
                "\"isbn\":\"tcy\",\n" +
                "\"aisle\":\"5578\",\n" +
                "\"author\":\" Yusuf Rahman\"\n" +
                "}\n";
    }

    public static String AddPlace() {
        return "{\n" +
                "  \"location\": {\n" +
                "    \"lat\": 32,6255 ,\n" +
                "    \"lng\": -97.0875\n" +
                "  },\n" +
                "  \"accuracy\": 75,\n" +
                "  \"name\": \"Mohammad Rah\",\n" +
                "  \"phone_number\": \"(214) 2222 4464\",\n" +
                "  \"address\": \"11 test street, Arlington, Tx-76002\",\n" +
                "  \"types\": [\n" +
                "    \"shoe park\",\n" +
                "    \"shop\"\n" +
                "  ],\n" +
                "  \"website\": \"https://webgopros.com\",\n" +
                "  \"language\": \"ENGLISH-US\"\n" +
                "}\n";
    }
}
