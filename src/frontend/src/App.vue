<template>

 <div class="vue-template">
     <!-- Navigation -->
     <nav class="navbar shadow bg-white rounded justify-content-between flex-nowrap flex-row fixed-top">
       <div class="container">

         <ul class="nav navbar-nav flex-row float-right">
           <li class="nav-item">
             <router-link class="nav-link pr-3" to="/login">Log In</router-link>
           </li>
           <li class="nav-item">
             <router-link class="btn btn-outline-primary" to="/register">Register</router-link>
           </li>
         </ul>
       </div>
     </nav>

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
// import Login from "@/views/LoginPage.vue";
// import Expenses from "@/views/ExpenseList.vue";


//import 'bootstrap'
//import 'bootstrap/dist/css/bootstrap.min.css'




export default {
  name: 'App',
  components: {

  }
}
</script>


