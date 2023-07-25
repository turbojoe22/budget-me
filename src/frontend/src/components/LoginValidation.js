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
  data() {
        name: 'LoginValidation',
    return {
      username: "",
      password: "",
      errorMessage: "",
    };
  },
  methods: {
    validateForm() {
      this.errorMessage = "";

      if (this.username === "" || this.username === "") {
        console.log("Please enter a username and/or password");

      },

    },
  },
};
</script>


<style>
</style>
