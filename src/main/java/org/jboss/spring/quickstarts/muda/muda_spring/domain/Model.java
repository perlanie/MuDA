package org.jboss.spring.quickstarts.greeter.greeter_spring.domain;
import java.io.*;
import java.util.HashSet;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Collections;

public class Model{
	public static HashMap<Integer,HashSet<Itemset>> frequentItemSets=new HashMap<Integer,HashSet<Itemset>>();
	public Model(String filePath){
		this.readModel(filePath);
	}
	public void readModel(String filePath){
		BufferedReader reader=null;
		String line=null;
		try{
			//opens file with dataset
			FileReader file = new FileReader(filePath);
			reader= new BufferedReader(file);
			while((line = reader.readLine()) != null){
				String[] items=line.trim().split("\\[|\\]|\\,|\\s ");

				//reads dataset and adds values to candidate set and L1 itemset
				int itemsetSize=items.length-1;
				List<String> itemList=new LinkedList<String>();
				for(String item:items){
					if(!item.equals("")){
						itemList.add(item);
					}
		
				}
				//System.out.println(itemList);
				if(frequentItemSets.containsKey(itemsetSize)){
					frequentItemSets.get(itemsetSize).add(new Itemset(itemList));
				}
				else{
					HashSet<Itemset>itemsets=new HashSet<Itemset>();
					itemsets.add(new Itemset(itemList));
					frequentItemSets.put(itemsetSize,itemsets);
				}
			
			}
			reader.close();
		}
		catch(Exception e){
			System.out.println("Error: Cannot open model file.");
		}

		//System.out.println(frequentItemSets);

	}
	
	/*========================================================
	getCombinations: Gets the different combinations of the 
	candidates.
	----------------------------------------------------------
	List<String> items: items that are candidates
	int itemSetSize: size of the item sets needed.
	==========================================================*/

	public List<List<String>> getCombinations(List<String> items, int itemSetSize) {

	    if (0 == itemSetSize || items.isEmpty()) {
	        return Collections.singletonList(Collections.<String> emptyList());
	    }

	    //holds the all te combinations
	    List<List<String>> combinations = new LinkedList<List<String>>(); 

	    String item = items.iterator().next();

	    List<String> subSet = new LinkedList<String>(items);
	    subSet.remove(item);

	    List<List<String>> subSetCombination = getCombinations(subSet, itemSetSize - 1);

	    for (List<String> set : subSetCombination) {
	        List<String> newSet = new LinkedList<String>(set);
	        newSet.add(0, item);
	       	if(newSet.size()==itemSetSize){
	       		combinations.add(newSet);
	       	}
	       		
	    }

	    combinations.addAll(getCombinations(subSet, itemSetSize));

		return combinations;
	}
	
	
	public  HashSet<String> getRecommendations(HashSet<String> likes, int numRecs){
		HashSet<String> recommendations=new HashSet<String>();
		HashSet<Itemset> itemsets=frequentItemSets.get(2);

		if(likes.size()<3){
			List<String> userLikes=new LinkedList<String>(likes);
			for(Itemset itemset:itemsets){
				HashSet<String> differences=itemset.getDifferences(new Itemset(userLikes));
				recommendations.addAll(differences);
			}
			

		}
		else{
			List<List<String>> combinations=getCombinations(new LinkedList<String>(likes),2);
			for(Itemset itemset:itemsets){
				for(List<String> comb:combinations){
					HashSet<String> differences=itemset.getDifferences(new Itemset(comb));
					recommendations.addAll(differences);
				}
			}
		}
		
		recommendations.removeAll(likes);
		System.out.println(recommendations);
		return recommendations;
	}

	public LinkedList<String> getDifferences(Itemset modelSet, Itemset userSet){
		LinkedList<String> differences = new LinkedList<String>();
		HashSet<String> modelItems = new HashSet<String> (modelSet.getItems());
		HashSet<String> userItems = new HashSet<String> (userSet.getItems());

		modelItems.removeAll(userSet.getItems());
		userItems.removeAll(modelSet.getItems());

		differences.addAll(modelItems);
		differences.addAll(userItems);

		System.out.println(differences);

		return differences;
	}

	public static void main(String[] args){
		Model model=new Model("D:\\Aprioi\\Model.txt");
		HashSet<String>mylikes = new HashSet<String>(){{add("0");}};
		model.getRecommendations(mylikes,5);
	}

}