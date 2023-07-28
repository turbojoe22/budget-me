<template>
    <div class="vue-template">

        <form @submit.prevent="validateForm">
            <h3>Sign Up</h3>

            <div class="form-group">
                <label for="username">Username</label>
                <input v-model="user.username" placeholder="username"/>
            </div>


            <div class="form-group">
                <label for="password">Password</label>
                <input v-model="user.password" placeholder="password"/>
            </div>


                <div id="error-container"></div>

            <button>Sign Up</button>

        </form>
    </div>
</template>

<script>
       export default {
               name: "RegisterPage",
               data() {
                   return {
                       registerStatus: "",
                       errorMessage: "",
                   user: {
                       username: null,
                       password: null,

                   },
               };
           },
               methods: {
                   async validateForm() {
                       const userLogin = {
                       method: "POST",
                       headers: {"Content-Type": "application/json"},
                       body: JSON.stringify(this.user),

                       };
                    console.log(userLogin);
                       const response = await fetch("/api/auth/register", userLogin);
                      console.log(response);


                   }
               }
           }
       </script>