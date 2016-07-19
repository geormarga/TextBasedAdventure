/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package features;

/**
 *
 * @author Aenaos
 */
public class FeatureController {
   
//            IMessage message = new FeatureNotFoundMessage();
//            message.display(attr);

    public Feature getFeature(String attr,FeatureFactory featureFactory){
         return featureFactory.createFeature(attr);
    }
}
