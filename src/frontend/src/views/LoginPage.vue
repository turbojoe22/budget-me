<template>
 <Login />
  <router-view>
  </router-view>
  <div class="bg"></div>
  <div class="bg bg2"></div>
  <div class="bg bg3"></div>
  <div class="page"></div>
  <div class="vue-template">

        <form @submit.prevent="validateForm">
            <h1>Login</h1>

            <div class="form-group">
                <label for="username">Username</label>
                <input v-model="user.username" placeholder="username" />
                <p v-if="errors.username">{{ errors.username }}</p>

            </div>

            <div class="form-group">
                <label for="password">Password</label>
                <input v-model="user.password" type="password" placeholder="password"/>
                <p v-if="errors.password">{{ errors.password }}</p>
            </div>


                <button type="submit">Sign In</button>

            <p>
                <router-link to="/register">Don't have an account? Register Here!</router-link>
            </p>

        </form>
    </div>
</template>

<style>
#page {
  background-color: rgba(245, 245, 245, 0.75);
  border-radius: .25em;
}

html {
  height:100%;
}

body {
  margin:0;
}

.bg {
  animation:slide 3s ease-in-out infinite alternate;
  background-image: linear-gradient(-60deg, rgba(102, 204, 51, 0.5) 50%, rgba(0, 153, 255, 0.5) 50%);
  bottom:0;
  left:-100%;
  opacity:.5;
  position:fixed;
  right:-100%;
  top:0;
  z-index:-1;
}

.bg2 {
  animation-direction:alternate-reverse;
  animation-duration:4s;
}

.bg3 {
  animation-duration:5s;
}



h1 {
  font-family:monospace;
}

@keyframes slide {
  0% {
    transform:translateX(-25%);
  }
  100% {
    transform:translateX(25%);
  }
}

html {
  background-color: rgba(0, 153, 255, 0.25);
}
  body {
    font-family: Arial, sans-serif;
    margin: 0;
    padding: 0;
  }

  ul {
    list-style-type: none;
    margin: 0;
    padding: 0;
    overflow: hidden;
  }

  li {
    float: left;
    margin-bottom: 5px;

  }

  div {
    max-width: 800px;
    margin: 0 auto;
    padding: 20px;
  }

  h1,h2 {
    margin-bottom: 20px;
    text-align: center;
  }

  form {
    margin-bottom: 20px;
  }

  label {
    display: block;
    margin-bottom: 5px;
  }
  input[type="text"],
  input[type="number"] {
    width: 100%;
    padding: 5px;
    margin-bottom: 10px;
    border: 1px solid #ccc;
    border-radius: 4px;
  }
  button {
    display: block;
    width: 40%;
    margin: auto;
    padding: 10px;
    background-color: #4caf50;
    color: white;
    border: none;
    border-radius: 4px;
    cursor: pointer;
    font-size: 16px;
  }

</style>


<script>

    export default {

        name: "LoginPage",
        data() {
            return {

                registrationStatus: "",

                    errors: {
                        username: "",
                        password: "",
                        },
            user: {
                username: "",
                password: "",

            },
        };
    },
        methods: {

            async validateForm() {
                if (this.user.username === null || this.user.username === '') {
                   this.errors.username = "Please enter username";
                        return;
                    }  if (this.user.password === null || this.user.password === '') {
                          this.errors.password = "Please enter password";
                        return;

                    } else {

                const userLogin = {
                method: "POST",
                headers: {"Content-Type": "application/json"},
                body: JSON.stringify(this.user),

                };

               const response = await fetch("/api/auth/login", userLogin);
               console.log(response);
               this.$router.push('/home');
            }
        }
    },
}
</script>