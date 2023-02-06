public class VigenereCipher {

    private String key;

    public VigenereCipher(String k){
        this.key=k;
        key = key.toLowerCase();
    }

    public String getKey() {
        return key;
    }
    public String encode(String Message) {
        if(key.length() < Message.length()){
            int x = Message.length();
            for (int i = 0; ; i++)
            {
                if (x == i)
                    i = 0;
                if (key.length() == Message.length())
                    break;
                key+=(key.charAt(i));
            }
        }
        String ans = "";
        Message = Message.toLowerCase();
        System.out.println(Message+" "+key+" ");
        for (int i = 0, j = 0; i < Message.length(); i++) {
            char letter = Message.charAt(i);
            if(letter<='a'||letter>='z'){
                ans+=letter;
                j = ++j % key.length();
                continue;
            }

            ans += (char)(((letter - 97) + (this.key.charAt(j)-97)) % 26 + 97);

            j = ++j % key.length();
        }
        return ans;
    }

    public String decode(String Message) {
        if(key.length() < Message.length()){
            int x = Message.length();
            for (int i = 0; ; i++)
            {
                if (x == i)
                    i = 0;
                if (key.length() == Message.length())
                    break;
                key+=(key.charAt(i));
            }
        }
        String ans = "";
        Message = Message.toLowerCase();
        System.out.println(Message+" "+key+" ");

        for (int i = 0, j = 0; i < Message.length(); i++) {
            char letter = Message.charAt(i);
            if(letter<'a'||letter>'z'){
                ans+=letter;
                j = ++j % key.length();
                continue;
            }
            ans += (char)((letter - key.charAt(j) + 26) % 26 + 97);
            System.out.println(letter+" "+ key.charAt(j)+" "+(char)((letter - key.charAt(j) + 26) % 26 + 97)+" "+ans);

            j = ++j % key.length();
        }
        return ans;
    }
    public String getAlphabet(){
        return "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
    }

}
