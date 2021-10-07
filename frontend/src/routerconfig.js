import { createWebHistory, createRouter } from "vue-router";
import postForm from "@/components/postForm";
import putForm from "@/components/putForm";
import Student from "@/components/Student";

const routes = [
    {
        path:'/', component : Student
    },
    {
        path:'/updateForm', component : postForm
    },
    {
        path:'/addForm', component: putForm
    }
]

const router = createRouter({
    history: createWebHistory(),
    routes
});

export default router;