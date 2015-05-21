package org.concordion.ext.demo.selenium;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import org.concordion.ext.tooltip.TooltipButton;

public class ToggleTooltipButton implements TooltipButton {

    private List<ActionListener> actionListeners;
    
    public ToggleTooltipButton() {
        actionListeners = new ArrayList<ActionListener>();
    }
    
    @Override
    public void addActionListener(ActionListener l) {
        actionListeners.add(l);
        
    }
    
    @Override
    public void removeActionListener(ActionListener l) {
        actionListeners.remove(l);
    }
    
    @Override
    public ActionListener[] getActionListeners() {
        ActionListener[] listenersArray = new ActionListener[actionListeners.size()];
        return actionListeners.toArray(listenersArray);
    }
    
    public void processActionEvent(ActionEvent e) {
        for(ActionListener a : actionListeners) {
            a.actionPerformed(e);
        }
    }
}
