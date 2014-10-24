/**
 */
package org.gemoc.agro.activitiesDSL;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Model</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.gemoc.agro.activitiesDSL.Model#getName <em>Name</em>}</li>
 *   <li>{@link org.gemoc.agro.activitiesDSL.Model#getCultures <em>Cultures</em>}</li>
 *   <li>{@link org.gemoc.agro.activitiesDSL.Model#getResourceKinds <em>Resource Kinds</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.gemoc.agro.activitiesDSL.ActivitiesDSLPackage#getModel()
 * @model
 * @generated
 */
public interface Model extends EObject
{
  /**
   * Returns the value of the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Name</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Name</em>' attribute.
   * @see #setName(String)
   * @see org.gemoc.agro.activitiesDSL.ActivitiesDSLPackage#getModel_Name()
   * @model
   * @generated
   */
  String getName();

  /**
   * Sets the value of the '{@link org.gemoc.agro.activitiesDSL.Model#getName <em>Name</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Name</em>' attribute.
   * @see #getName()
   * @generated
   */
  void setName(String value);

  /**
   * Returns the value of the '<em><b>Cultures</b></em>' containment reference list.
   * The list contents are of type {@link org.gemoc.agro.activitiesDSL.Culture}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Cultures</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Cultures</em>' containment reference list.
   * @see org.gemoc.agro.activitiesDSL.ActivitiesDSLPackage#getModel_Cultures()
   * @model containment="true"
   * @generated
   */
  EList<Culture> getCultures();

  /**
   * Returns the value of the '<em><b>Resource Kinds</b></em>' containment reference list.
   * The list contents are of type {@link org.gemoc.agro.activitiesDSL.ResourceKind}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Resource Kinds</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Resource Kinds</em>' containment reference list.
   * @see org.gemoc.agro.activitiesDSL.ActivitiesDSLPackage#getModel_ResourceKinds()
   * @model containment="true"
   * @generated
   */
  EList<ResourceKind> getResourceKinds();

} // Model