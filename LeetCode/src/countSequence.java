import java.util.HashMap;

public class countSequence {
public RandomListNode copyRandomList(RandomListNode head) {
	
	HashMap<RandomListNode,RandomListNode> hm = new HashMap<RandomListNode,RandomListNode>();
	
	RandomListNode rln = head;
	
	RandomListNode newHead  = new RandomListNode(rln.label);
	
	RandomListNode newrln = newHead;
	
	while(rln != null)
	{
		hm.put(rln,newrln);
		if(rln.next !=null)
			newrln.next = new RandomListNode(rln.next.label);
		rln = rln.next;
		newrln = newrln.next;
		
	}
	
	newrln = newHead;
	rln = head;
	
	while(newrln != null )
	{
		newrln.random = hm.get(rln.random);
		newrln = newrln.next;
		rln = rln.next;
		
	}
		
	return newHead;
      
    }
    
    public static void main(String[] args)
    {
    	countSequence cs = new countSequence();
    	RandomListNode head = new RandomListNode(1);
    	head.next = new RandomListNode(2);
    	head.next.next = new RandomListNode(3);
    	head.random = head.next.next;
    	head.next.random = head;
    	head.next.next.random = head;
    	RandomListNode newHead = cs.copyRandomList(head);
    	RandomListNode temp = newHead;
    	while(temp != null)
    	{
    	System.out.println(temp.random.label + " -> ");
    	temp = temp.next;
    	}
    	
    }
}