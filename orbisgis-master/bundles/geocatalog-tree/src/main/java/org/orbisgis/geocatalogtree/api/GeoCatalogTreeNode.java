/**
 * OrbisGIS is a java GIS application dedicated to research in GIScience.
 * OrbisGIS is developed by the GIS group of the DECIDE team of the 
 * Lab-STICC CNRS laboratory, see <http://www.lab-sticc.fr/>.
 *
 * The GIS group of the DECIDE team is located at :
 *
 * Laboratoire Lab-STICC – CNRS UMR 6285
 * Equipe DECIDE
 * UNIVERSITÉ DE BRETAGNE-SUD
 * Institut Universitaire de Technologie de Vannes
 * 8, Rue Montaigne - BP 561 56017 Vannes Cedex
 * 
 * OrbisGIS is distributed under GPL 3 license.
 *
 * Copyright (C) 2007-2014 CNRS (IRSTV FR CNRS 2488)
 * Copyright (C) 2015-2017 CNRS (Lab-STICC UMR CNRS 6285)
 *
 * This file is part of OrbisGIS.
 *
 * OrbisGIS is free software: you can redistribute it and/or modify it under the
 * terms of the GNU General Public License as published by the Free Software
 * Foundation, either version 3 of the License, or (at your option) any later
 * version.
 *
 * OrbisGIS is distributed in the hope that it will be useful, but WITHOUT ANY
 * WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS FOR
 * A PARTICULAR PURPOSE. See the GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License along with
 * OrbisGIS. If not, see <http://www.gnu.org/licenses/>.
 *
 * For more information, please consult: <http://www.orbisgis.org/>
 * or contact directly:
 * info_at_ orbisgis.org
 */
package org.orbisgis.geocatalogtree.api;

import javax.swing.tree.MutableTreeNode;
import java.util.Map;
import java.util.Set;

/**
 * Node generated by {@link org.orbisgis.geocatalogtree.api.TreeNodeFactory}
 * @author Nicolas Fortin
 */
public interface GeoCatalogTreeNode extends MutableTreeNode {
    // Node type
    String NODE_DATABASE = "DATABASE";
    String NODE_CATALOG = "CATALOG";
    String NODE_SCHEMA = "SCHEMA";
    String NODE_TABLE = "TABLE";
    String NODE_COLUMNS = "COLUMNS";
    String NODE_COLUMN = "COLUMN";
    String NODE_INDEXES = "INDEXES";
    String NODE_INDEX = "INDEX";

    // Properties
    /** boolean, {@link #isEditable()} */
    String PROP_EDITABLE = "EDITABLE";
    /** string, {@link org.orbisgis.sif.components.fstree.TreeNodeCustomLabel} */
    String PROP_LABEL = "LABEL";
    /** boolean, Is NODE_TABLE is a spatial table */
    String PROP_SPATIAL_TABLE = "SPATIAL_TABLE";
    /** boolean, Is NODE_COLUMN is a spatial column */
    String PROP_COLUMN_SPATIAL = "COLUMN_SPATIAL";
    /** string, Column type identifier {@link java.sql.Types} */
    String PROP_COLUMN_TYPE_NAME = "COLUMN_TYPE_NAME";
    /** Is children has to be sorted */
    String PROP_ALPHABETICAL_SORTED_CHILDREN = "PROP_ALPHABETICAL_SORTED_CHILDREN";

    /**
     * @return Node type
     */
    String getNodeType();

    /**
     * @return The factory that create this node
     */
    TreeNodeFactory getFactory();

    /**
     * @return True if children has to be sorted
     */
    boolean isChildrenSorted();

    /**
     * @return Node identifier
     */
    String getNodeIdentifier();

    @Override
    GeoCatalogTreeNode getParent();

    /**
     * @return Identifier set of all child
     */
    Map<String, GeoCatalogTreeNode> getChildrenIdentifier();

    /**
     * @return True if this node value can be edited by the user
     */
    boolean isEditable();

    /**
     * @param attributeName Attribute identifier
     * @return Value of this attribute or null if not exists
     */
    Object getAttributeValue(String attributeName);

    /**
     * @param attributeName Attribute identifier
     * @param defaultValue Default value if attribute does not exists
     * @return Value of this attribute or defaultValue if not exists
     */
    Object getAttributeValue(String attributeName, Object defaultValue);

    /**
     * @return List of attributes
     */
    Set<String> getAttributes();

    /**
     * @param attributeName Attribute identifier
     * @param attributeValue Attribute value
     * @return This
     */
    GeoCatalogTreeNode set(String attributeName, Object attributeValue);
}