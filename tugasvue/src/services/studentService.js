import http from "../http-common";

class studentKelas {
    create(data) {
        return http.post("/student/insert", data);
    }

    getAll() {
        return http.get("/student/getAll");
    }

    updateMurid(id, data) {
        return http.put(`/student/update/${id}`, data);
    }

    deleteMurid(id) {
        return http.delete(`/student/delete/${id}`);
    }

    getById(id) {
        return http.get(`/student/getId/${id}`);
    }
}

export default new studentKelas();