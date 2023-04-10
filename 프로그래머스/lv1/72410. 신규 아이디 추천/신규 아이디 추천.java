class Solution {
    public String solution(String new_id) {
        String answer = "";

        new_id = new_id.toLowerCase();

        new_id = new_id.replaceAll("[^a-z0-9-_.]","");

        new_id = new_id.replaceAll("\\.+\\.", "\\.");


        if (new_id.indexOf(".") == 0)
            new_id = new_id.substring(1);

        if (new_id.length() > 0) {
            if (new_id.lastIndexOf(".") == (new_id.length() - 1))
                new_id = new_id.substring(0, new_id.length() - 1);
        }

        if (new_id.isBlank() || new_id.isEmpty())
            new_id = "a";

        if (new_id.length() >= 16)
            new_id = new_id.substring(0,15);

        if (new_id.lastIndexOf(".") == (new_id.length()-1))
            new_id = new_id.substring(0, new_id.length()-1);


        while (new_id.length() < 3){
            new_id += new_id.substring(new_id.length()-1, new_id.length());
        }

        System.out.println(new_id);

        return new_id;
    }
}