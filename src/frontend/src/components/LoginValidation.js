//<template>
//</template>
//
//<script>
//        function validateForm() {
//            let username = document.getElementById("username").value;
//            let password = document.getElementById("password").value;
//            let errorContainer = document.getElementById("error-container");
//            let errorMessages = [];
//
//            if (username.trim() === "") {
//                errorMessages.push("Please enter a username");
//                }
//
//            if (password.trim() === "") {
//                errorMessages.push("Please enter a password");
//                }
//
//            if (errorMessages.length > 0) {
//                errorContainer.innerHTML = "";
//                for (let i = 0; i < errorMessages.length; i++) {
//                    let errorMessage = document.createElement("p");
//                    errorMessage.textContent = errorMessages[i];
//                    errorContainer.appendChild(errorMessage);
//                }
//                return false;
//            }
//
//            return true;
//        }
//</script>
//
//<style>
//</style>
