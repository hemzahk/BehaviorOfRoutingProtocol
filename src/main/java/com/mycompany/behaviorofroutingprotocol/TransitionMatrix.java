/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.behaviorofroutingprotocol;

import java.util.Random;

/**
 *
 * @author PC
 */
public class TransitionMatrix {
    double[][] transitionMatrix;
    double p;
    Random rand;
    double[] Pi0;
    
    static final int S0 = 0;  
    static final int S1 = 1;  
    static final int S2 = 2;  
    static final int S3 = 3;  
    static final int S4 = 4; 
    static final int S5 = 5;
    

    
    public TransitionMatrix(double p) {
        this.p = p;
        transitionMatrix = new double [6][6];
        Pi0 = new double[6];
        this.rand = new Random();
        
        // first row : 
        
        transitionMatrix[S0][S0]= 0;
        transitionMatrix[S0][S1]= p;
        transitionMatrix[S0][S2]= 0;
        transitionMatrix[S0][S3]= 0;
        transitionMatrix[S0][S4]= 1-p;
        transitionMatrix[S0][S5]= 0;
        
        // second row : 
        
        transitionMatrix[S1][S0]= 0;
        transitionMatrix[S1][S1]= 0;
        transitionMatrix[S1][S2]= p;
        transitionMatrix[S1][S3]= 0;
        transitionMatrix[S1][S4]= 1-p;
        transitionMatrix[S1][S5]= 0;
        
        // third row : 
        
        transitionMatrix[S2][S0]= 0;
        transitionMatrix[S2][S1]= 0;
        transitionMatrix[S2][S2]= 0;
        transitionMatrix[S2][S3]= p;
        transitionMatrix[S2][S4]= 1-p;
        transitionMatrix[S2][S5]= 0;
        
        // fourth row : 
        
        transitionMatrix[S3][S0]= 0;
        transitionMatrix[S3][S1]= 0;
        transitionMatrix[S3][S2]= 0;
        transitionMatrix[S3][S3]= 0;
        transitionMatrix[S3][S4]= 1-p;
        transitionMatrix[S3][S5]= p;
        
        // fifth row : 
        
        transitionMatrix[S4][S0]= 0;
        transitionMatrix[S4][S1]= 0;
        transitionMatrix[S4][S2]= 0;
        transitionMatrix[S4][S3]= 0;
        transitionMatrix[S4][S4]= 1;
        transitionMatrix[S4][S5]= 0;
        
        // sixth row : 
        
        transitionMatrix[S5][S0]= 0;
        transitionMatrix[S5][S1]= 0;
        transitionMatrix[S5][S2]= 0;
        transitionMatrix[S5][S3]= 0;
        transitionMatrix[S5][S4]= 0;
        transitionMatrix[S5][S5]= 1;
        
        // initializing Pi0 (vector) : 
        
        for(int i =0;i < 6;i++) {
                this.Pi0[i]=transitionMatrix[0][i];
        }
        
        
    }
    
    public void printTransitionMatrix() {
        for (int i = 0; i < transitionMatrix.length; i++) {
            for (int j = 0; j < transitionMatrix[i].length; j++) {
                System.out.printf("%.1f ", transitionMatrix[i][j]);
            }
            System.out.println();
        }
    }
    
    public int getNextState(int currentState) {
        double random = 3/4; //rand.nextDouble();
        double cumulativeProbability = 0.0;
        
        for(int nextState = 1;nextState < 6;nextState++) {
            cumulativeProbability += transitionMatrix[currentState][nextState];
            if(  random < cumulativeProbability) {
                System.out.printf("\n The next state will be : S%d \n", nextState);
                return nextState;
            }
        }
        return currentState;
    }
    
    public double[] state(int currentState) {
        double[] state= new double[6];
        for(int i =0;i < 6;i++) {
                state[i]=transitionMatrix[currentState][i];
        }
        
        return state;
    }
    
    public double[] calculateDistribution() {
        double[] result = new double[6];
        for (int i = 0; i < 6; i++) {
            double sum = 0;
            for (int j = 0; j < 6; j++) {
                sum += transitionMatrix[i][j] * Pi0[j];
                
            }
            result[i] = sum;
            System.out.printf("(%.1f)", result[i]);
        }
        
        
        return result;
    }
    
}
