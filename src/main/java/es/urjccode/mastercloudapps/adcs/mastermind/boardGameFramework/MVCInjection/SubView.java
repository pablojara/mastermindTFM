package es.urjccode.mastercloudapps.adcs.mastermind.boardGameFramework.MVCInjection;

import es.urjccode.mastercloudapps.adcs.mastermind.boardGameFramework.utils.Console;

public abstract class SubView {

    protected Console console;

    public SubView(){
        this.console = new Console();
    }
    public abstract void interact(AceptorController aceptorController);

}
