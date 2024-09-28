public class Tree <T extends Comparable<T>>
{
    Node root;
    class Node
    {
        T value;
        Node left;
        Node right;
        Node(T value)
        {
            this.value = value;
            right = left = null;
        }
    }

    Tree()
    {
        root = null;
    }
    Tree(T value)
    {
        root = new Node(value);
    }
    Node getRoot(){return  root;}

    private void lRVBypass(Node node)
    {
        if (node != null) {
            lRVBypass(node.left);
            lRVBypass(node.right);
            System.out.println(node.value.toString());
        }
    }

    private void lVRBypass(Node node)
    {
        if (node != null)
        {
            lVRBypass(node.left);
            System.out.println(node.value.toString());
            lVRBypass(node.right);
        }
    }

    private void vLRBypass(Node node)
    {
        if (node != null)
        {
            System.out.println(node.value.toString());
            vLRBypass(node.left);
            vLRBypass(node.right);
        }
    }

    private void insertPrivate(Node node, T value)
    {
        int compare = value.compareTo(node.value);
        if(compare < 0 )
        {
            if(node.left == null )
            {
                node.left = new Node(value);
            }
            else
            {
                insertPrivate(node.left,value);
            }
        }
        else
        {
            if(compare == 0)
            {
                return;
            }

            if(node.right == null)
            {
                node.right = new Node(value);
            }
            else
            {
                insertPrivate(node.right,value);
            }
        }
    }

    private Node findPrivate(Node node, T value)
    {
        int compare = node.value.compareTo(value);
        if (compare == 0)
        {
            return node;
        }
        if (compare < 0)
        {
            if(node.right!= null)
            {
                return findPrivate(node.right, value);
            }
        }
        else
        {
            if(node.left!= null)
            {
                return findPrivate(node.left, value);
            }

        }
        return null;
    }

    private Node deletePrivate(Node node, T value)
    {
        int compare = value.compareTo(node.value);
        if(compare < 0)
        {
            if(node.left!= null)
            {
                node.left = deletePrivate(node.left,value);
            }
        }
        else
        {
            if(compare > 0 )
            {
                if(node.right!= null)
                {
                    node.right = deletePrivate(node.right,value);
                }
            }
            else
            {
                if(node.left == null || node.right == null)
                {
                    node = (node.left == null)?node.right:node.left;
                }
                else
                {
                    Node minInRight = getMin(node.right);
                    node.value = minInRight.value;
                    node.right = deletePrivate(node.right, minInRight.value);
                }
            }
        }
        return node;
    }

    Node getMin(Node node)
    {
        if(node == null)
        {
            return null;
        }
        if(node.left == null)
        {
            return  node;
        }
        return getMin(node.left);
    }

    Node getMax(Node node)
    {
        if(node == null)
        {
            return null;
        }
        if(node.right == null)
        {
            return  node;
        }
        return getMax(node.right);
    }

    public void insert(T value)
    {
        if (root == null)
        {
            root = new Node(value);
        } else {
            insertPrivate(root, value);
        }
    }

    Node find(T value)
    {
        if (root == null)
        {
            return null;
        } else
        {
            return findPrivate(root, value);
        }
    }

    Node delete(T value)
    {
        if(root == null)
        {
            return  null;
        }
        else
        {
            if (find(value) == null)
            {
                return null;
            }
            else
                {
                    return deletePrivate(root, value);
                }
        }
    }

    void vertexLeftRightBypass()
    {
        vLRBypass(root);
    }

    void leftVertexRightBypass()
    {
        lVRBypass(root);
    }

    void leftRightVertexBypass()
    {
        lRVBypass(root);
    }
}