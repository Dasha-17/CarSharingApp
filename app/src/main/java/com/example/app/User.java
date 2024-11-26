package com.example.app;

public class User {
        private String firstName;
        private String lastName;
        private String login;
        private String password;
        private String job;

        @Override
        public String toString() {
                return lastName;
        }

        public User(String firstName, String lastName, String login, String password, String job) {
                this.firstName = firstName;
                this.lastName = lastName;
                this.login = login;
                this.password = password;
                this.job = job;
        }

        public User() {
        }

        public String getFirstName() {
                return firstName;
        }

        public void setFirstName(String firstName) {
                this.firstName = firstName;
        }

        public String getLastName() {
                return lastName;
        }

        public void setLastName(String lastName) {
                this.lastName = lastName;
        }

        public String getLogin() {
                return login;
        }

        public void setLogin(String login) {
                this.login = login;
        }

        public String getPassword() {
                return password;
        }

        public void setPassword(String password) {
                this.password = password;
        }

        public String getJob() {
                return job;
        }

        public void setJob(String job) {
                this.job = job;
        }
}
