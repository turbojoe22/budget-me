<template>
    <h1>Home Page</h1>
    <button @click="getAnswer">Go</button>
    <p>{{ answer }}</p>
    <h2>Connect To Plaid</h2>
        <button @click="connectToBank">Link Account</button>
        <p>{{ hi }}</p>
</template>

<script>

export default {
mounted(){
      let Plaid = document.createElement('script')
      Plaid.setAttribute('src', 'https://cdn.plaid.com/link/v2/stable/link-initialize.js')
      document.head.appendChild(Plaid)
    },
  beforeMount(){
  this.hi = window.Plaid
  },
  name: 'HomePage',
  data() {
    return {
     answer: "",
     pl: null,
     link_token: null,
    };
  },
  methods: {
    async getAnswer() {
      const response = await fetch("/api/getAnswer");
      const answer = await response.json();
      this.answer = answer.data;
      console.log(answer.data);
    },
    async connectToBank() {
        const response = await fetch("/api/generateLinkToken");
        const plResponse = await response.json();
        this.link_token = plResponse.link_token;
        console.log(this.link_token);


    }
  }
}
</script>

