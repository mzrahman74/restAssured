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
                "    \"lat\": 32.62,\n" +
                "    \"lng\": -97.08\n" +
                "  },\n" +
                "  \"accuracy\": 50,\n" +
                "  \"name\": \"Mohammad Rahman\",\n" +
                "  \"phone_number\": \"(+1) 211-111-1111\",\n" +
                "  \"address\": \"Misty Meadow Ln\",\n" +
                "  \"types\": [\n" +
                "    \"website\",\n" +
                "    \"visit\"\n" +
                "  ],\n" +
                "  \"website\": \"https://webgopros.com\",\n" +
                "  \"language\": \"English-US\"\n" +
                "}\n";
    }

    public static String UpdatePlace(String placeId) {
        return "{\n" +
                "\t\"place_id\":\""+placeId+"\",\n" +
                "\t\"address\": \"255 plano street, USA\",\n" +
                "\t\"key\":\"qaclick123\"\n" +
                "\t\n" +
                "}";
    }
    public static String postJson() {
        return "{\n" +
                "    \"title\": \"Computer\",\n" +
                "    \"body\": \"IT\",\n" +
                "    \"userId\": 200\n" +
                "}";
    }
}
