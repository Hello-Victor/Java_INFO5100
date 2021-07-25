/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.WorkQueue;

import Business.Customer.*;

/**
 *
 * @author red
 */

public enum OrderState {
    INIT("已下单"),ASSIGN("已接单"),RECEIVED("已送到"),EVALUATED("已评价");

        private String name;
        private OrderState(String name){
            this.name=name;
        }
        
        public String getValue() {
            return name;
        }

        @Override
        public String toString() {
            return name;
        }
}