package com.google.devtools.j2objc.ast;


import javax.lang.model.element.Element;
import javax.lang.model.type.TypeMirror;

// MIREGO kotlin interop (whole file)

/**
 * Node for accessing a field via the "." notation
 */
public class PropertyAccess extends Expression {

  private ChildLink<Name> qualifier = ChildLink.create(Name.class, this);
  private ChildLink<SimpleName> name = ChildLink.create(SimpleName.class, this);

  public PropertyAccess() {}

  public PropertyAccess(Element element, TypeMirror type, Name qualifier) {
    super();
    this.qualifier.set(qualifier);
    name.set(new SimpleName(element, type));
  }

  public PropertyAccess(PropertyAccess other) {
    super(other);
    qualifier.copyFrom(other.getQualifier());
    name.copyFrom(other.getName());
  }

  @Override
  public Kind getKind() {
    return Kind.PROPERTY_ACCESS;
  }

  @Override
  public TypeMirror getTypeMirror() {
    SimpleName nameNode = name.get();
    return nameNode != null ? nameNode.getTypeMirror() : null;
  }

  public Name getQualifier() {
    return qualifier.get();
  }

  public PropertyAccess setQualifier(Name newQualifier) {
    qualifier.set(newQualifier);
    return this;
  }

  public SimpleName getName() {
    return name.get();
  }

  public PropertyAccess setName(SimpleName newName) {
    name.set(newName);
    return this;
  }

  public String getAccessStatement() {
    return qualifier.get().getFullyQualifiedName() + "." + name.get().getIdentifier();
  }

  @Override
  protected void acceptInner(TreeVisitor visitor) {
    if (visitor.visit(this)) {
      qualifier.accept(visitor);
      name.accept(visitor);
    }
    visitor.endVisit(this);
  }

  @Override
  public PropertyAccess copy() {
    return new PropertyAccess(this);
  }
}
