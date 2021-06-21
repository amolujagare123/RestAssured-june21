package util;

public class Payload {

    public static String createUserPayload()
    {
        return "{\n" +
                "    \"name\": \"morpheus\",\n" +
                "    \"job\": \"leader\"\n" +
                "}";
    }

    public static  String createUserChat(String username,String password,String email
    , String name,String surname,String nickname)
    {
        return  "{\n" +
                "  \"username\": \""+username+"\",\n" +
                "  \"password\": \""+password+"\",\n" +
                "  \"email\": \""+email+"\",\n" +
                "  \"name\": \""+name+"\",\n" +
                "  \"surname\": \""+surname+"\",\n" +
                "  \"chat_nickname\": \""+nickname+"\",\n" +
                "  \"departments\": [\n" +
                "    1,\n" +
                "    2\n" +
                "  ],\n" +
                "  \"departments_read\": [\n" +
                "    2\n" +
                "  ],\n" +
                "  \"department_groups\": [\n" +
                "    1\n" +
                "  ],\n" +
                "  \"user_groups\": [\n" +
                "    1\n" +
                "  ]\n" +
                "}";
    }

    public static  String createUserChat()
    {
        return  "{\n" +
                "    \"username\": \"avinash\",\n" +
                "    \"password\": \"avinash123\",\n" +
                "    \"email\": \"avinash@example.org\",\n" +
                "    \"name\": \"avinash\",\n" +
                "    \"surname\": \"parmar\",\n" +
                "    \"chat_nickname\": \"avi\",\n" +
                "    \"departments\": [\n" +
                "        1,\n" +
                "        2\n" +
                "    ],\n" +
                "    \"departments_read\": [\n" +
                "        2\n" +
                "    ],\n" +
                "    \"department_groups\": [\n" +
                "        1\n" +
                "    ],\n" +
                "    \"user_groups\": [\n" +
                "        1\n" +
                "    ]\n" +
                "}";
    }

    public static String updateUser(String name,String surname,String nickName)
    {
        return "{\n" +
                "    \"name\": \""+name+"\",\n" +
                "    \"surname\": \""+surname+"\",\n" +
                "    \"chat_nickname\": \""+nickName+"\",\n" +
                "    \"departments\": [\n" +
                "        1,\n" +
                "        2\n" +
                "    ],\n" +
                "    \"departments_read\": [\n" +
                "        2\n" +
                "    ],\n" +
                "    \"department_groups\": [\n" +
                "        1\n" +
                "    ],\n" +
                "    \"user_groups\": [\n" +
                "        1\n" +
                "    ]\n" +
                "}";
    }


    public static String sampleCreateUserPayload(String name,String job)
    {
        return "{\n" +
                "    \"name\": \""+name+"\",\n" +
                "    \"job\": \""+job+"\"\n" +
                "}";
    }


}
