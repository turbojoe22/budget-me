<template>
  <hello-world></hello-world>
  <router-link to="/login">Login</router-link>
  <router-link to="/transactions">Transaction List</router-link>
  <router-link to="/expenses">Expenses</router-link>
  <router-view/>
</template>


<style>

</style>


<script>
import HelloWorld from './components/Example.vue'
// import Transactions from "@/views/TransactionsList.vue";
// import Login from "@/views/LoginPage.vue";
// import Expenses from "@/views/ExpenseList.vue";

export default {
  name: 'App',
  components: {
    HelloWorld,

  }
}
</script>


