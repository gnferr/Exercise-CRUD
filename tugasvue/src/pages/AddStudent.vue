<template>
    <div>
        <Navbar></Navbar>
        <Form></Form>
        <Copy></Copy>
    </div>
</template>

<script>
import Form from '@/components/FormStudent.vue';
import Navbar from '@/components/Navbar.vue';
import Copy from '@/components/Copyright.vue';
export default {
    name:"AddPage",
    components:{
        Form,
        Navbar,
        Copy
    }
}
</script>

<style>

</style>