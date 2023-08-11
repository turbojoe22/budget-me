<template>
  <div id = "nav">
    <ul>

      <li>
        <router-link  to="/" ><img src="../../../main/java/com/myPersonalFinance/budgetme/assets/budgetlogo.png" height="48" width="48"/>
          Home</router-link>
      </li>

    </ul>

  </div>
  <br>
 <Login />
  <router-view>
  </router-view>

  <div id="page">
    <form @submit.prevent="loginUser">
      <h1>Login</h1>
      <div>
        <label for="username">Username</label>
        <input v-model="username" type="text" placeholder="Username" required />
      </div>
      <div>
        <label for="password">Password</label>
        <input v-model="password" type="password" placeholder="Password" required />
      </div>
      <button type="submit">Login</button>

      <p v-if="errorMessage">{{ errorMessage }}</p>

      <p>
        <router-link to="/register">Don't have an account? Register Here!</router-link>
      </p>

    </form>
  </div>




</template>

<style>



</style>

<script>

export default {

  data() {
    return {
      username: "",
      password: "",
      errorMessage: "",
    };
  },
  methods: {
    async loginUser() {
      const user = {
        username: this.username,
        password: this.password,
      };

      try {
        const response = await fetch("/api/auth/login", {
          method: "POST",
          headers: {"Content-Type": "application/json"},
          body: JSON.stringify(user),
        });


        if (response.ok) {

          this.$router.push('/home');


        } else if (!response.ok) {

          this.errorMessage = "Invalid credentials. Please try again or register.";
        } else {

          this.errorMessage = "Login failed. Please try again later.";

        }
      } catch (error) {

        console.error("Error during login", error);

        this.errorMessage = "Username not found. Please register for an account!";
      }

    }
  }
}
</script>

