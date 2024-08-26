/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package transfer.util;

/**
 *
 * @author stefan
 */
public interface Operation {

    public static final int LOGIN = 0;

    public static final int GET_ALL_ADMINISTRATOR = 1;

    public static final int ADD_VATERPOLISTA = 2;
    public static final int DELETE_VATERPOLISTA = 3;
    public static final int UPDATE_VATERPOLISTA = 4;
    public static final int GET_ALL_VATERPOLISTA = 5;

    public static final int ADD_TURNIR = 6;
    public static final int DELETE_TURNIR = 7;
    public static final int UPDATE_TURNIR = 8;
    public static final int GET_ALL_TURNIR = 9;

    public static final int GET_ALL_UTAKMICA = 10;

    public static final int GET_ALL_TIM = 11;
    public static final int DELETE_TIM = 12;
    public static final int ADD_TIM = 13;
    public static final int UPDATE_TIM = 14;

    public static final int GET_ALL_IGRAC = 15;

    public static final int GET_ALL_GRAD = 16;
    
}
