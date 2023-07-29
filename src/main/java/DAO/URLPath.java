package DAO;

public class URLPath {
    public enum Database {
        LocalHost_MySQL("jdbc:mysql://localhost:3306/PhotoNow", "root", "1203"),
        RemoteHost_MySQL("jdbc:mysql://tlswltjq.iptime.org:3306/PhotoNow", "root", "1203");

        private final String url;
        private final String username;
        private final String password;

        Database(String url, String username, String password) {
            this.url = url;
            this.username = username;
            this.password = password;
        }

        public String getUrl() {
            return url;
        }

        public String getUsername() {
            return username;
        }

        public String getPassword() {
            return password;
        }
    }
}
