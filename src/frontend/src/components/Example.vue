<template>
    <h1>Home Page</h1>
    <button @click="getAnswer">Go</button>
    <p>{{ answer }}</p>
    <h2>Connect To Plaid</h2>
        <button @click="connectToBank">Link Account</button>
        <div>{{pl}}</div>
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
     link_token: null,

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

//Gets the access token as a string and returns it, will eventually return other data

    async getAccessToken(publicToken) {
     const publicTokenResponse = await fetch ("/api/createAccessToken", {
               method: 'POST',
               headers: {'Content-Type': 'application/x-www-form-urlencoded;charset=UTF-8'},
               body: JSON.stringify({public_token: publicToken})
               });
     const data = await publicTokenResponse.json();
     const accessToken = data.accessToken;
     console.log(accessToken);
     return accessToken;
     },

//Link popup init and public token handler

    async connectToBank() {
      const handler = window.Plaid.create({
         token : await this.getLinkToken(),

         onSuccess: async (publicToken, metadata) => {
           console.log(`Finished with Link! ${JSON.stringify(metadata)}`);
           try {
           const access_token = await this.getAccessToken(publicToken);
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

