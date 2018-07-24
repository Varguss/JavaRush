package com.javarush.task.task32.task3209.listeners;

import com.javarush.task.task32.task3209.View;

import javax.swing.*;
import javax.swing.event.MenuEvent;
import javax.swing.event.MenuListener;
import java.awt.*;
import java.util.Arrays;

public class TextEditMenuListener implements MenuListener {
    private View view;

    @Override
    public void menuSelected(MenuEvent menuEvent) {
        JMenu menu = (JMenu) menuEvent.getSource();

        Arrays.stream(menu.getMenuComponents()).forEach((item) -> item.setEnabled(view.isHtmlTabSelected()));
    }

    @Override
    public void menuDeselected(MenuEvent menuEvent) {

    }

    @Override
    public void menuCanceled(MenuEvent menuEvent) {

    }

    public TextEditMenuListener(View view) {
        this.view = view;
    }
}
