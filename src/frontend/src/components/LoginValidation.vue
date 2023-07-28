<template>
  <div>
    <input v-model="username" class="text"/>
    <input v-model="password" class="password" />

    <div class="error-container"></div>
        <p>{{ errorMessage }}</p>
        <button @click="handleLogin">Submit</button>
   </div>
</template>

<script>
export default {
 name: 'LoginValidation',
  data() {

    return {
      username: "",
      pwHash: "",

    };
  },
  methods: {
    validateForm() {
      this.errorMessage = "";

      if (this.username === "" || this.password === "") {
        console.log("Please enter a username and/or password");

      }

    }
  }
};
</script>


<style>
</style>
