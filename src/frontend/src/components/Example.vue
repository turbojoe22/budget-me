<template>
    <h1>Home Page</h1>
    <button @click="getAnswer">Go</button>
    <p>{{ answer }}</p>
    <h2>Connect To Plaid</h2>
        <button @click="connectToBank">Link Account</button>
        <div>{{}}</div>
</template>

<script>
export default {
mounted(){
      let Plaid = document.createElement('script')
      Plaid.setAttribute('src', 'https://cdn.plaid.com/link/v2/stable/link-initialize.js')
      document.head.appendChild(Plaid)
    },


  name: 'HomePage',
  data() {
    return {
     answer: "",
     pl: window.Plaid,


    };
  },
methods: {

//Test code, just grabs a string

    async getAnswer() {
      const response = await fetch("/api/getAnswer");
      const answer = await response.json();
      this.answer = answer.data;
      console.log(answer.data);
    },

//Gets the link token as a string and returns it

      async getLinkToken() {
         const linkTokenResponse =  await fetch("api/generateLinkToken");
         const data = await linkTokenResponse.json();
         const linkToken = data.linkToken;
         console.log(linkToken);
         return linkToken;
         },

//Link popup init and public token handler

    async connectToBank() {
      const handler = window.Plaid.create({
         token : await this.getLinkToken(),

         onSuccess: async (public_token, metadata) => {
         console.log(public_token, metadata);
            await fetch ("api/createAccessToken", {
                method: 'POST',
                headers: {'Content-Type': 'text/plain'},
                body: public_token
            });
           await this.getBalance();
           },
         onExit: async (err, metadata) => {
           console.log(
             `Exited early. Error: ${JSON.stringify(err)} Metadata: ${JSON.stringify(
               metadata
             )}`
           );
         },
         onEvent: (eventName, metadata) => {
           console.log(`Event ${eventName}, Metadata: ${JSON.stringify(metadata)}`);
         },
       });
       handler.open();

      },

    async getBalance(){
      const response = await fetch("api/getBalance");
      const data = await response.json();
      const balances = data.balances;
      console.log(balances);

    }

    }
  }

</script>

