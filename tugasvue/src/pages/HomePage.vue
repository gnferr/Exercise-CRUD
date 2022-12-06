<template>
    <div>
        <Navbar></Navbar>  
        <Card></Card>
        <Copy></Copy>
    </div>
</template>

<script>
import Navbar from '@/components/Navbar.vue';
import Card from '@/components/InfoCard.vue';
import Copy from '@/components/Copyright.vue';
export default {
    name: "HomePages",
    components: {
        Navbar,Card,Copy
    }
}
</script>

<style>

</style>