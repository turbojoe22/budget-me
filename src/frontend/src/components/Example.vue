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
mounted(){
      let Plaid = document.createElement('script')
      Plaid.setAttribute('src', 'https://cdn.plaid.com/link/v2/stable/link-initialize.js')
      document.head.appendChild(Plaid)
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
      const handler = window.Plaid.create({
         token : await fetch("api/generateLinkToken"),

         onSuccess: async (publicToken, metadata) => {
           console.log(`Finished with Link! ${JSON.stringify(metadata)}`);
           try {

           const publicToken = await fetch ("/api/createPublicToken", {
           method: 'POST',
           headers: {'Content-Type': 'application/x-www-form-urlencoded;charset=UTF-8'},
           body: JSON.stringify({publicToken})
           })



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

