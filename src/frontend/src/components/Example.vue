<template>
    <h1>Home Page</h1>
    <button @click="getAnswer">Go</button>
    <p>{{ answer }}</p>
    <h2>Connect To Plaid</h2>
        <button @click="connectToBank">Link Account</button>
        <p>{{}}</p>
</template>

<script>
export default {

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

    async getAccessToken(publicToken) {
     const publicTokenResponse = await fetch ("/api/createAccessToken", {
               method: 'POST',
               headers: {'Content-Type': 'application/x-www-form-urlencoded;charset=UTF-8'},
               body: JSON.stringify({public_token: publicToken})
               });
     const accessToken = await publicTokenResponse.json();
     console.log(accessToken);
     return accessToken;
     },

     async getLinkToken() {
     const linkTokenResponse =  await fetch("api/generateLinkToken");
     const linkToken = await linkTokenResponse.json();
     console.log(linkToken)
     return linkToken;
     },

    async connectToBank() {
      const handler = Plaid.create({
         token : this.getLinkToken(),

         onSuccess: async (publicToken, metadata) => {
           console.log(`Finished with Link! ${JSON.stringify(metadata)}`);
           try {
           const access_token = this.getAccessToken(publicToken);
           console.log(access_token);
           } catch (error){
           console.log('Error, ${JSON.stringify(err)');
           }
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


    }
  }

</script>

