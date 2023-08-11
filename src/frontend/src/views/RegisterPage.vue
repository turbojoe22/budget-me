<template>
  <div id = "nav">
    <ul>

      <li>
        <router-link  to="/" ><img src="../../../main/java/com/myPersonalFinance/budgetme/assets/budgetlogo.png" height="48" width="48"/>
          Home</router-link>
      </li>


    </ul>

  </div>
  <router-view></router-view>
  <br>

  <div id="page">
    <form @submit.prevent="registerUser">
      <h1>Sign Up</h1>
      <div>
        <label for="username">Username</label>
        <input v-model="username" type="text" placeholder="Username" required />
      </div>
      <div>
        <label for="password">Password</label>
        <input v-model="password" type="password" placeholder="Password" required />
      </div>
      <div>
        <label for="verifyPassword">Verify Password</label>
        <input v-model="verifyPassword" type="password" placeholder="Verify Password" required />
      </div>
      <button type="submit">Sign Up</button>

      <p>
        <router-link to="/login">Already have an account? Login Here!</router-link>
      </p>
    </form>
  </div>


    </template>

    <script>
    export default {


      data() {
        return {
          username: "",
          password: "",
          verifyPassword: "",
        };
      },
      methods: {
        async registerUser() {
          if (this.password !== this.verifyPassword) {
            alert("Passwords do not match");
            return;
          }

          const user = {
            username: this.username,
            password: this.password,
          };

          try {
            const response = await fetch("/api/auth/register", {
              method: "POST",
              credentials: 'include',
              headers: { "Content-Type": "application/json" },
              body: JSON.stringify(user),
            });
            if (response.ok) {
              this.$router.push('/home');

            } else if (response.status === 409) {
              alert("Username already exists. Please login!");

            } else {
              alert("Registration failed");

            }
          } catch (error) {
            console.error("Error during registration", error);

          }
        },
      },
    };
    </script>
