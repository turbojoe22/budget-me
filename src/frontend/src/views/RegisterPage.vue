<template>
    <div class="vue-template">

        <form @submit.prevent="validateForm">
            <h3>Sign Up</h3>

            <div class="form-group">
                <label for="username">Username</label>
                <input v-model="user.username" placeholder="username"/>
                <p>{{ errorUsername }}</p>
            </div>


            <div class="form-group">
                <label for="password">Password</label>
                <input v-model="user.password" placeholder="password"/>
                <p>{{ errorPassword }}</p>
            </div>

            <div class="form-group">
                <label for="verifyPassword">Verify Password</label>
                <input v-model="user.verifyPassword" placeholder="verify password" />
                <p>{{ errorVerifyPassword }}</p>
            </div>



            <button>Sign Up</button>

        </form>
    </div>
</template>

<script>
       export default {
               name: "RegisterPage",
               data() {
                   return {
                       registrationStatus: "",
                       errorUsername: "",
                       errorPassword: "",
                       errorVerifyPassword: "",
                   user: {
                       username: null,
                       password: null,
                       verifyPassword: null,

                   },
               };
           },
               methods: {
                   async validateForm() {
                       if (this.user.username === null || this.user.username === '') {
                          this.errorUsername = "Please enter username";

                          }  if (this.user.password === null || this.user.password === '') {
                                this.errorPassword = "Please enter password";
                                return;
                              } else if (this.user.password !== this.user.verifyPassword) {
                                this.errorVerifyPassword = "Passwords do not match";
                                return;
                       }  else {
                       const userLogin = {
                       method: "POST",
                       headers: {"Content-Type": "application/json"},
                       body: JSON.stringify(this.user),

                       };

                      const response = await fetch("/api/auth/register", userLogin);
                      console.log(response);

                   }
              }
           },
}
       </script>