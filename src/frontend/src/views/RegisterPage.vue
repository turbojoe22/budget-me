<template>
<Register />
  <router-view></router-view>
  <div class="bg"></div>
  <div class="bg bg2"></div>
  <div class="bg bg3"></div>
 <div class="page"></div>
    <div class="vue-template">
        <form @submit.prevent="validateForm">
            <h1>Sign Up</h1>

            <div class="form-group">
                <label for="username">Username</label>
                <input v-model="user.username" placeholder="username" />
                <p v-if="errors.username">{{ errors.username }}</p>
                <p v-if="errors.usernameMessage">{{ errors.usernameMessage }}</p>
            </div>


            <div class="form-group">
                <label for="password">Password</label>
                <input v-model="user.password" type="password" placeholder="password"/>
                <p v-if="errors.password">{{ errors.password }}</p>
            </div>

            <div class="form-group">
                <label for="verifyPassword">Verify Password</label>
                <input v-model="user.verifyPassword" type="password" placeholder="verify password"/>
                <p v-if="errors.verifyPassword">{{ errors.verifyPassword }}</p>
            </div>



            <button type="submit">Sign Up</button>


        </form>
    </div>
</template>

<script>

       export default {

               name: "RegisterPage",
               data() {
                   return {
                       registrationStatus: "",

                             errors: {
                               username: "",
                               password: "",
                               verifyPassword: "",
                               usernameMessage: "",
                             },
                   user: {
                       username: "",
                       password: "",
                       verifyPassword: "",

                   },
               };
           },
               methods: {
                   async validateForm() {
                       if (this.user.username === null || this.user.username === '') {
                          this.errors.username = "Please enter username";
                                return;


                          } if (this.user.password === null || this.user.password === '') {
                                this.errors.password = "Please enter password";
                                return;
                          } else if (this.user.password !== this.user.verifyPassword) {
                                this.errors.verifyPassword = "Passwords do not match";
                                return;



                          } else {

                       const userRegister = {
                        method: "POST",
                        headers: {"Content-Type": "application/json"},
                        body: JSON.stringify(this.user),


                       };

                      const response = await fetch("/api/auth/register", userRegister);
                      console.log(response);
                      this.$router.push('/home');
           }
       },
   },
}
       </script>