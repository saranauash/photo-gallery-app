# Photo Gallery Application — Software Design Patterns Final Project

**Group:** SE-2506  
**Team Members:** Aisulu Amanzhol, Sara Nauash  

## Project Overview
A console-based Java application demonstrating the coordinated use of **six software design patterns** within a unified Photo Gallery system. Users can add photos and videos, apply runtime image filters, dynamically switch sorting strategies, remove files, export configured albums, and view a complete activity log.

## Implemented Design Patterns

### Sara Nauash
- **Decorator (`decorator`):** Dynamically wraps images at runtime to combine filters (`GrayscaleDecorator`, `SepiaDecorator`, `BlurDecorator`) without subclass explosion.
- **Strategy (`strategy`):** Allows runtime switching between sorting algorithms (`SortByNameStrategy`, `SortByDateStrategy`, `SortByRatingStrategy`).
- **Builder (`builder`):** Step-by-step construction and validation of immutable album export configurations (`AlbumExportConfig`).
