<template>
  <TheNavigation/>
  <br>
  <div id="page">
    <h1>Transaction List</h1>
    <button @click="getTransactions">Update Transactions</button>
  </div>

<select v-model="selected">
<option
v-for="option in options" v-bind:key="option.id" :value="option.id">{{option.name}}</option>

</select>

    <table class="styled-table">
      <thead>
          <tr>
              <th>Merchant Name</th>
              <th>Amount</th>
              <th>Date</th>
              <th>Category</th>
          </tr>
      </thead>

      <tbody>
          <tr v-for="actualTransaction in transactions" :key="actualTransaction.id">
              <td>
                  <div>
                  {{ actualTransaction.merchantName }}
                  </div>

              </td>
              <td>
                  <div>
                  {{ actualTransaction.amount }}
                  </div>

              </td>
              <td>
                  <div>
                  {{ actualTransaction.date }}
                  </div>
              </td>
              <td>
                  <div>
                  {{ actualTransaction.category }}
                  </div>
              </td>
          </tr>
      </tbody>
    </table>
</template>


<script >
import TheNavigation from "@/views/TheNavigation.vue";

    export default {
        data(){
            return {
            transactions: null,
            selected: 1,
            options: [
                {name:'Date: New to Old', id:1},
                {name:'Date: Old to New', id:2},
                {name:'Amount: High to Low', id:3},
                {name:'Amount: Low to High', id:4},
                {name:'Category: A to Z', id:5},
                {name:'Category: Z to A', id:6},
            ]

            };
        },
        created () {
        this.getTransactions(this.selected)
        },
        watch: {
        selected(){
            this.getTransactions(this.selected);
            }
        },
        methods: {
        async getTransactions(option){
        if(option === 1){
            const response = await fetch("/api/transactions/getTransactionsNewestFirst", {credentials: 'same-origin'});
            this.transactions = await response.json();
        } else if (option == 2){
             const response = await fetch("/api/transactions/getTransactionsOldestFirst", {credentials: 'same-origin'});
             this.transactions = await response.json();
        } else if (option === 3){
        const response = await fetch("/api/transactions/getTransactionsAmountHighest", {credentials: 'same-origin'});
        this.transactions = await response.json();
        } else if (option === 4){
        const response = await fetch("/api/transactions/getTransactionsAmountLowest", {credentials: 'same-origin'});
        this.transactions = await response.json();
        } else if (option === 5){
        const response = await fetch("/api/transactions/getTransactionsCategoryAToZ", {credentials: 'same-origin'});
        this.transactions = await response.json();
        } else if (option === 6){
        const response = await fetch("/api/transactions/getTransactionsCategoryZToA", {credentials: 'same-origin'});
        this.transactions = await response.json();
        }
        },
        },

  components: {
    TheNavigation,
  },
}
</script>