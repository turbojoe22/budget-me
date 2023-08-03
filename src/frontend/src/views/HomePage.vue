<template>
  <TheNavigation/>
  <br>
  <div id="page">
    <h1>Welcome to Budget Me</h1>
<!--    <button @click="getAnswer">Go</button>-->
<!--    <p>{{ answer }}</p>-->
    <h2>Choose an account to Link
      <button @click="connectToBank">Link Account</button>
    </h2>
  <br>
  <br>
    <h2>
      Learn how to manage your money and become <br>debt-free, while saving for your
      financial goals.
      <router-link to="/expenses" custom v-slot="{ navigate }"><button @click="navigate" role="link">Start my budget</button></router-link>

    </h2>
        <div>{{}}</div>
  </div>
</template>
<style>

</style>

<script>
export default {
  // import not working
  import TheNavigation
  mounted(){
      let Plaid = document.createElement('script')
      Plaid.setAttribute('src', 'https://cdn.plaid.com/link/v2/stable/link-initialize.js')
      document.head.appendChild(Plaid)
    },

  name: 'HomePage',
  components: {
    TheNavigation,
  },
  data() {
    return {
     answer: "",
     pl: window.Plaid,


    };
  },
methods: {

//Test code, just grabs a string
    // async getAnswer() {
    //   const response = await fetch("/api/getAnswer");
    //   const answer = await response.json();
    //   this.answer = answer.data;
    //   console.log(answer.data);
    // },

//Gets the link token as a string and returns it

      async getLinkToken() {
         const linkTokenResponse =  await fetch("api/link/generateLinkToken");
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
            await fetch ("api/link/createAccessToken", {
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

    },
    // timeoutInMS = 180000; // 3 minutes -> 3 * 60 * 1000
    //  timeoutId;
    //
    // function handleInactive() {
    //     // Here you want to logout a user and/or ping your token
    // }
    //
    // function startTimer() {
    //     // setTimeout returns an ID (can be used to start or clear a timer)
    //     timeoutId = setTimeout(handleInactive, timeoutInMS);
    // }
    //
    // function resetTimer() {
    //     clearTimeout(timeoutId);
    //     startTimer();
    // }
    //
    // function setupTimers () {
    //     document.addEventListener("keypress", resetTimer, false);
    //     document.addEventListener("mousemove", resetTimer, false);
    //     document.addEventListener("mousedown", resetTimer, false);
    //     document.addEventListener("touchmove", resetTimer, false);
    //
    //     startTimer();
    // }
    //
         }
      }



</script>


