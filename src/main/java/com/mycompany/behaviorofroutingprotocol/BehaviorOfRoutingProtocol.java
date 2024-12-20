/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.behaviorofroutingprotocol;



/**
 *
 * @author PC
 */
public class BehaviorOfRoutingProtocol {

    public static void main(String[] args) {
        // Creating a transition matrix object associated with the model :
        
        TransitionMatrix transitionMatrix = new TransitionMatrix(0.5);
        System.out.println("Transition Matrix:");      
        transitionMatrix.printTransitionMatrix();
        
        // Getting the next state based on random number and a cumulative probability : 
        
        transitionMatrix.getNextState(0);
       
        // Calculating and printing the distribution vector of the next state : 
       
       transitionMatrix.calculateDistribution();
       
    }
}
