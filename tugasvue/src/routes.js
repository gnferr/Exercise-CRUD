import Add from './pages/AddStudent.vue';
import HomePages from "./pages/HomePage.vue";
import Update from "./pages/UpdatePage.vue";

export default [
    {
        path: "/add",
        component: Add,
    },
    {
        path: "",
        component: HomePages
    },
    {
        path: "/update/:id",
        name: 'UpdateStd',
        component: Update
    }
];