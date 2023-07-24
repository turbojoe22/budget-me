<template>
  <TheNavigation/>
  <router-view></router-view>
</template>


<style>
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

  li a {
    display: block;
    padding: 8px;
    background-color: whitesmoke;
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
  }

</style>


<script>
import TheNavigation from "@/views/TheNavigation.vue";


export default {
  name: 'App',
  components: {

   TheNavigation,

  }
}
</script>


