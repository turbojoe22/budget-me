<template>


 <div class="vue-template">
     <!-- Navigation -->
       <div class="container">
           <div class="nav-item"><router-link class="nav-link pr-3" to="/login">Log In</router-link></div>
           <div class="nav-item">
             <router-link to="/register">Register</router-link></div>


       </div>


     <!-- Main -->
     <div class="App">

       <div class="vertical-center">

         <div class="inner-block">
           <router-view />
         </div>
       </div>
     </div>
   </div>

</template>


<style>

</style>

<script>


// import Transactions from "@/views/TransactionsList.vue";
//import Login from "@/views/LoginPage.vue";
// import Expenses from "@/views/ExpenseList.vue";


//import 'bootstrap'
//import 'bootstrap/dist/css/bootstrap.min.css'




export default {
  name: 'App',
  components: {


  }
}
</script>


