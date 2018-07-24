package com.javarush.task.task36.task3608.view;

import com.javarush.task.task36.task3608.bean.User;
import com.javarush.task.task36.task3608.controller.Controller;
import com.javarush.task.task36.task3608.model.ModelData;

public class UsersView implements View {
    private Controller controller;

    @Override
    public void refresh(ModelData modelData) {
        System.out.println(modelData.isDisplayDeletedUserList() ? "All deleted users:" : "All users:");
        for(User s : modelData.getUsers())
            System.out.println("\t"+s);
        System.out.println("===================================================");
    }

    public void fireEventOpenUserEditForm(long id) {
        controller.onOpenUserEditForm(id);
    }

    public void fireEventShowAllUsers() {
        controller.onShowAllUsers();
    }

    public void fireEventShowDeletedUsers() {
        controller.onShowAllDeletedUsers();
    }



    @Override
    public void setController(Controller controller) {
        this.controller = controller;
    }
}
