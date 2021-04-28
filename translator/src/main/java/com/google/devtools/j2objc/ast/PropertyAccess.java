package com.google.devtools.j2objc.ast;


import javax.lang.model.type.TypeMirror;

// MIREGO kotlin interop (whole file)

/**
 * Node for accessing a field via the "." notation
 */
public class PropertyAccess extends Expression {

    private final ChildLink<Expression> receiver = ChildLink.create(Expression.class, this);
    private final ChildLink<Name> propertyName = ChildLink.create(Name.class, this);

    public PropertyAccess(Expression receiver, Name propertyName) {
        super();
        this.receiver.copyFrom(receiver);
        this.propertyName.set(propertyName);
    }

    public PropertyAccess(PropertyAccess other) {
        super(other);
        receiver.copyFrom(other.receiver.get());
        propertyName.copyFrom(other.getPropertyName());
    }

    @Override
    public Kind getKind() {
        return Kind.PROPERTY_ACCESS;
    }

    @Override
    public TypeMirror getTypeMirror() {
        Name nameNode = propertyName.get();
        return nameNode != null ? nameNode.getTypeMirror() : null;
    }

    public Expression getReceiver() {
        return receiver.get();
    }

    public Name getPropertyName() {
        return propertyName.get();
    }

    public PropertyAccess setPropertyName(SimpleName newName) {
        propertyName.set(newName);
        return this;
    }

    @Override
    protected void acceptInner(TreeVisitor visitor) {
        if (visitor.visit(this)) {
            receiver.accept(visitor);
            propertyName.accept(visitor);
        }
        visitor.endVisit(this);
    }

    @Override
    public PropertyAccess copy() {
        return new PropertyAccess(this);
    }

    @Override
    public String toString() {
        return receiver.toString() + "." + propertyName.toString();
    }
}
