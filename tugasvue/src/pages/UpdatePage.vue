<template>
    <div>
        <Navbar></Navbar>
        <FormStudent :studentProps="dataStudent"></FormStudent>
        <Card v-show="none" @updateMuridFunc="updateStudent"></Card>
        <Copyright></Copyright>
    </div>
</template>

<script>
import Navbar from '@/components/Navbar.vue';
import FormStudent from '@/components/FormStudent.vue';
import Card from '@/components/InfoCard.vue';
import Copyright from '@/components/Copyright.vue';
export default {
    name:"UpdatePage",
    components:{
        Navbar,FormStudent,Copyright,Card
    },
    methods:{
        updateStudent(item){
            this.dataStudent = item
        }
        
    },
    data(){
        return{
            dataStudent : null,
        }
    }
}
</script>

<style>

</style>