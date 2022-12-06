<template>
    <div class="d-flex justify-content-center">
        <div class="col-6">
         <div class="card">
        <div class="card-header">
            <h3>Success!</h3>
        </div>
        <div class="card-body">
            <p>Student data has been {{successVal}}!</p>
            <button v-show="successVal == 'Deleted'" @click="iniReload" class="btn btn-primary">Close</button>
            <router-link v-show="successVal != 'Deleted'" to="/" class="btn btn-primary">Close</router-link>
        </div>
    </div>
    </div>
  </div>
</template>

<script>
export default {
    name:"SuccessForm",
    props: ['successVal'],
    methods:{
        iniReload(){
            location.reload();
        }
    }
}
</script>

<style>

</style>